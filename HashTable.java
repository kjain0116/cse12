/* 
* NAME: Kavita Jain
* PID: A10560035
* LOGIN: cs12uag
*/

package hw5;

import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
* Implementation of a Hash Table
* 
* @author Kavita Jain
* @version 1.0
* @since 8/3/17
*/
public class HashTable implements IHashTable {

    //You will need a HashTable of LinkedLists.
    public enum HashType {
        ONE,
        TWO,
        THREE
    }

    private int nelems;  //Number of element stored in the hash table
    private int expand;  //Number of times that the table has been expanded
    private int collision;  //Number of collisions since last expansion
    private String statsFileName;     //FilePath for the file to write statistics upon every rehash
    private boolean printStats = false;   //Boolean to decide whether to write statistics to file or not after rehashing
    private HashType type;	//type of hash function being used
    private LinkedList<String>[] array;	//hash table array used to store strings 
    private int size;	//size of the hash table
    private double loadFactor;	//load factor of the hash table
    private int longestChain;	//longest known collision chain
    private FileWriter fw = null;	//filewriter
    private BufferedWriter bw = null;	//bufferedwriter
    private PrintWriter pw = null;	//printwriter
   
    /**
     * Constructor for hash table
     *
     * @param size Initial dimensions of the hash table
     * @param type Specified hash function
     */
    public HashTable(int size, HashType type) {
        //Initialize
    	this.size = size;
    	array = new LinkedList[this.size];
    	for(int i = 0; i < this.size; i++)
    		array[i] = new LinkedList<String>();
    	this.type = type;
    	nelems = 0;
    	expand = 0;
    	collision = 0;
    	loadFactor = (double)nelems/this.size;
    	longestChain = 0;
    }

    /**
     * Constructor for hash table
     *
     * @param size Initial dimensions of the hash table
     * @param type Specified hash function
     * @param fileName path to write file statistics
     */
    public HashTable(int size, HashType type, String fileName) {
        //Set printStats to true and statsFileName to fileName
    	this.size = size;
    	array = new LinkedList[this.size];
    	for(int i = 0; i < this.size; i++)
    		array[i] = new LinkedList<String>();
    	this.type = type;
    	nelems = 0;
    	expand = 0;
    	collision = 0;
    	loadFactor = (double)nelems/this.size;
    	printStats = true;
    	statsFileName = fileName;
    	longestChain = 0;
    }

    /**
     * Insert the string value into the hash table
     *
     * @param value value to insert
     * @throws NullPointerException if value is null
     * @return true if the value was inserted, false if the value was already
     * present
     */
    @Override
    public boolean insert(String value) {
    	if(value == null)
    		throw new NullPointerException();
    	if(array[this.hash(value)].contains(value))
    		return false;
    	else {
    		if(array[this.hash(value)].size() != 0)
        		collision++;
    		array[this.hash(value)].add(value);
    		nelems++;
    		loadFactor = (double)nelems/size;
    		if(loadFactor > .666)
    			this.rehash();
    		return true;
    	}
    }

    /**
     * Delete the given value from the hash table
     *
     * @param value value to delete
     * @throws NullPointerException if value is null
     * @return true if the value was deleted, false if the value was not found
     */
    @Override
    public boolean delete(String value) {
    	if(value == null)
    		throw new NullPointerException();
        
    	if(!this.contains(value))
    		return false;
    	else {
    		array[this.hash(value)].remove(value);
    		nelems--;
    		loadFactor = (double)nelems/size;
    		return true;
    	}
    }

    /**
     * Check if the given value is present in the hash table
     *
     * @param value value to look up
     * @throws NullPointerException if value is null
     * @return true if the value was found, false if the value was not found
     */
    @Override
    public boolean contains(String value) {
    	if(value == null)
    		throw new NullPointerException();
    	if(array[this.hash(value)].contains(value))
    		return true;
    	else 
    		return false;
    }

    /**
     * Print the contents of the hash table. Print nothing if table is empty
     *
     * Example output for this function:
     *
     * 0:
     * 1:
     * 2: marina, fifty
     * 3: table
     * 4:
     */
    @Override
    public void printTable() {
        for(int i = 0; i < this.size; i++) {
        	System.out.print(i+": ");
        	if(array[i].size() != 0) 
        		System.out.print(array[i].get(0));
        	for(int j = 1; j < array[i].size(); j++) {
        		System.out.print(", " + array[i].get(j));
        	}
        	System.out.println();
        }
    }

    /**
     * Return the number of elements currently stored in the hashtable
     *
     * @return nelems
     */
    @Override
    public int getSize() {
        return nelems;
    }

    /**
     * Calculates the length of the longest known collision chain in the hash table
     */
    private void calcLongestChain() {
    	for(int i = 0; i < size; i++) {
    		if(array[i].size() > longestChain)
    			longestChain = array[i].size();
    	}
    }
    
    /**
     * expands and rehashes the items into the table when load factor goes over the threshold.
     */
    private void rehash() {
    	this.calcLongestChain();
    	expand++;
    	if(printStats == true)	//print stats to file if given
    		this.printStatistics();
    	LinkedList<String>[] temp = array;	//create temp array for old hash table
    	size = 2*size;	//expands table
    	collision = 0;	//reset values
    	nelems = 0;
    	loadFactor = (double)nelems/size;
    	longestChain = 0;
    	LinkedList<String>[] newArray = new LinkedList[size];
    	for(int i = 0; i < size; i++)
    		newArray[i] = new LinkedList<String>();
    	array = newArray;	//set hash table array to the expanded array
    	for(int j = 0; j < temp.length; j++) {
    		for(int k = 0; k < temp[j].size(); k++) {
    			String value = temp[j].get(k);
    			this.insert(value);	
    		}
    	}
    }
    
    /**
     * Prints the statistics after each expansion. 
     * This method will be called from rehash only if printStats=true
     */
    private void printStatistics() {
    	try {
    		File file = new File(statsFileName);
    		// if file doesn't exist, then create it
    		if (!file.exists()) {
    			file.createNewFile();
    		}
			fw = new FileWriter(file.getAbsoluteFile(), true);
			bw = new BufferedWriter(fw);
	    	pw = new PrintWriter(bw);
	    	pw.write(expand+" resizes, load factor ");
	    	String lfString = String.format("%.2f", loadFactor);
	    	pw.write(lfString);
	    	pw.write(", "+collision+" collisions, "+longestChain+" longest chain");
	    	pw.println();
	    	pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
    }
    
    /**
     * This is a wrapper method to allow you to swap hash functions without
     * cluttering up your other code.
     *
     * @param value String to hash
     * @return Hash value based upon the enum
     */
    protected int hash(String value) {
        //replace the specified return statements with calls to your hash
        // functions, passing through the string to hash
        switch (type) {
            case ONE:
                return this.hashFunc1(value); //first function here, ex: FVN1A(value);
            case TWO:
                return this.hashFunc2(value);
            case THREE:
                return this.hashFunc3(value);
            default:
                return 0;
        }
    }
    
    /**
     * First hash function. Rolling hash using Horner's Method.
     * @param key String value to be hashed
     * @return hash index for the table 
     */
    private int hashFunc1(String key) {
    	int hashVal = 0;
    	for(int j=0; j<key.length(); j++) {
    		int letter = key.charAt(j);	// get char code
    		hashVal = (hashVal * 27 + letter) % this.size;
    	}
    	return hashVal;
    }

    /**
     * Second hash function. Cyclical Redundancy Checking Method.
     * @param key String value to be hashed
     * @return hash index for the table
     */
    private int hashFunc2(String key) {
    	int hashValue = 0;
    	for(int i=0; i<key.length(); i++) {
    		int leftShiftedValue = hashValue <<5;	//left shift
    		int rightShiftedValue = hashValue >>>27;	//right shift
    		hashValue = (leftShiftedValue | rightShiftedValue) ^ key.charAt(i);
    	}
    	return Math.abs(hashValue) % this.size;
    }
    
    /**
     * Third hash function. Hashes a string by interpreting it as a base-256 number.
     * @param key String value to be hashed
     * @return hash index for the table
     */
    private int hashFunc3(String key) {
    	int hashValue = 0;
    	final int BYTE_WIDTH = 8;
    	for(int i=0; i<key.length(); i++) {
    		hashValue = (hashValue << BYTE_WIDTH) + key.charAt(i);
    		hashValue %= this.size;
    	}
    	return hashValue;
    }
}
