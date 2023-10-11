/**
 * Ishaan Sayal
 * Data Structures Period 2
 * 10/5/2023
 */
public class Person implements Comparable<Person>
{
   /**
      Constructs an Item object.
      @param k the key string
      @param v the value of the item
   */
   public Person(String k, String v)
   { 
      key = k;
      value = v;
   }
   
   /**
      Gets the key.
      @return the key
   */
   public String getKey()
   { 
      return key;
   }
   
   /**
      Gets the value.
      @return the value
   */
   public String getValue()
   { 
      return value;
   }

   public int compareTo(Person otherObject)
   {
      Person other = (Person) otherObject;
      return key.compareTo(other.key);
   }
   @Override
   public String toString() 
   {
       return "Key: " + key + " Value: " + value;
   }

   private String key;
   private String value;
}