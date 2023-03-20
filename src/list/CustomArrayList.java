package list;
import java.util.Arrays;
import java.util.Collection;

class Book implements Comparable<Book>{
  private String title;
  private String author;
  private String category;
  private static String sorting;
  private int publicationYear;

  public Book(String title, String author, String category, int publicationYear) {
    this.title = title;
    this.author = author;
    this.category = category;
    this.publicationYear = publicationYear;
  }
  public static void setSort(String sorting) {
	  Book.sorting=sorting;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public String getCategory() {
    return category;
  }

  public int getPublicationYear() {
    return publicationYear;
  }

  @Override
  public String toString() {
    return title + " by " + author + " (" + publicationYear + ")";
  }
  public int compareTo(Book a) {  
	  if(Book.sorting=="publicationYear") {
		  return this.publicationYear==a.publicationYear?0:this.publicationYear>a.publicationYear?1:-1;  
	  }
	  if(Book.sorting=="category") {
		  return this.category.compareTo(a.category);  
	  }
	  if(Book.sorting=="author") {
		  return this.author.compareTo(a.author);  
	  }
      return this.title.compareTo(a.title);  
      }
}

class Library {
  private Arraylist<Book> books;

  public Library() {
    books = new Arraylist<Book>();
  }

  public void addBook(Book book) {
    books.add(book);
  }

  public void printBooks() {
    for (int i=0;i<books.size();i++) {
      System.out.println(books.get(i));
    }
  }
  public void setSort(String sorting) {
	  Book.setSort(sorting);
  }
}
 public class CustomArrayList{
	 public static void main(String[] args) {
		    Library library = new Library();
		    library.setSort("publicationYear");
		    library.addBook(new Book("No time to die", "James Bond", "Fiction", 2021));
		    library.addBook(new Book("Darkness awakens", "Jane Austen", "psycho", 1999));
		    library.addBook(new Book("The zodiac", "RDJ", "Criminal", 2004));
		    library.printBooks();
		    System.out.println();
		    Arraylist <Integer> test= new Arraylist<Integer>();
		    test.add(1);
		    test.add(1);
		    test.add(1);
		    test.add(1);
		    test.fill(5);
		    test.pop();
		    System.out.println(test.join("-"));
	}
 }
  class Arraylist <A> {
	    	    A[] arr;
	    	    @SuppressWarnings("unchecked")
	    	    Arraylist(){
	    	    	arr=(A[])new Object[0];
	    	    }
	    	    @SuppressWarnings("unchecked")
	    	    Arraylist(int i){
	    	    arr=(A[])new Object[i];
	    	    }
	    	    @SuppressWarnings("unchecked")
	    	    Arraylist(Collection<A> collection){
	    	    	arr =(A[])collection.toArray();
	    	    }
	    	    
	    	    
	    	    // A[] array = (A[]) java.lang.reflect.Array.newInstance(String.class, collection.size());
	    	    //add
	    	    @SuppressWarnings("unchecked")
				public boolean add(A i){
	    	       A[] arr1 =(A[]) new Object[arr.length+1];
	    	       System.arraycopy(arr,0,arr1,0,arr.length);
	    	       arr1[arr1.length-1]=i; 
	    	       Arrays.sort(arr1);
	    	       arr=arr1;
	    	       return true;
	    	    }
	    	    //set
	    	     @SuppressWarnings("unchecked")
				public A set(int index,A obj){
	    	       arr[index]=obj;
	    	       Arrays.sort(arr);
	    	       return (A) arr;
	    	    }
	    	    //remove the first occurence
	    	     @SuppressWarnings("unchecked")
				public boolean remove(Object obj){
	    	    A[] arr1 =(A[]) new Object[arr.length-1];
	    	    int a = -1;
	    	    for(int i =0;i<arr.length;i++){
	    	      if(arr[i].equals(obj)){
	    	        a=i;
	    	        break;
	    	      }
	    	    }
	    	    if(a==-1){
	    	      System.out.println("no elements found");
	    	      return false;
	    	    }
	    	    else{
	    	    int j =0;
	    	    for(int k =0;k<arr.length;k++){
	    	         if(k==a){
	    	         continue;
	    	         }
	    	         arr1[j]=arr[k];
	    	         j++;
	    	    }
	    	    arr = arr1;
	    	    return true;
	    	    }
	    	    
	    	    }
	    	    // remove all
	    	    @SuppressWarnings("unchecked")
	    	   void removeAll(A obj){
	    	    int a = 0;
	    	    for(int i =0;i<arr.length;i++){
	    	      if(arr[i].equals(obj)){
	    	        a+=1;
	    	      }
	    	    }
	    	    if(a==0){
	    	      System.out.println("no elements found");
	    	    }
	    	    else{
	    	     A[] arr1 =(A[]) new Object[arr.length-a];
	    	    int j =0;
	    	    for(int k =0;k<arr.length;k++){
	    	         if(arr[k].equals(obj)){
	    	         continue;
	    	         }
	    	         arr1[j]=arr[k];
	    	         j++;
	    	    }
	    	    arr = arr1;
	    	    }
	    	    
	    	     }
	    	     //remove range
	    	    @SuppressWarnings("unchecked")
				protected void removeRange(int a ,int b){
	    	     A[] arr1 =(A[]) new Object[arr.length-(b-a)];
	    	    int j =0;
	    	    for(int k =0;k<arr.length;k++){
	    	         if(k>=a&&k<b){
	    	         continue;
	    	         }
	    	         arr1[j]=arr[k];
	    	         j++;
	    	    }
	    	    arr = arr1;
	    	     }
	    	    
	    	    //clear
	    	     @SuppressWarnings("unchecked")
				public void clear(){
	    	    arr=(A[])new Object[0];
	    	    }
	    	     
	    	    public A get(int index){
	    	      return arr[index];
	    	    }
	    	    
	    	    //to string
	    	    public String toString(){
	    	      A[] arr1=arr;
	    	      return Arrays.toString(arr1);
	    	    }
	    	    //
	    	    public int size(){
	    	     return arr.length;
	    	    }
	    	    //
	    	    public boolean isEmpty(){
	    	     return arr.length==0;
	    	    }
	    	    //
            
                //
                public int indexOf(Object o) {
                	for (int i =0;i<arr.length;i++) {
                	    if (arr[i].equals(o)) {
                	        return i;
                	    }
                	}
					return -1;
                }
                //
                public int lastIndexOf(Object o) {
                	int j=-1; 
                	for (int i =0;i<arr.length;i++) {
                	    if (arr[i].equals(o)) {
                	        j++;
                	    }
                	}
                	if(j==-1) {
                		return j;
                	}
					return j+1;
                }
                //
                public boolean contains(Object toCheckValue) {
                	for (A element : arr) {
                	    if (element.equals(toCheckValue)) {
                	        return true;
                	    }
                	}
					return false;
                }
                //
                public String join(String i) {
                	String out="";
                	for(int j=0;j<arr.length;j++) {
                		if(j==(arr.length-1)) {
                			out+=arr[j];
                		}
                		else{
                			out+=arr[j]+i;
                		}
                	}
                	return out;
                }
                //
                @SuppressWarnings("unchecked")
                public void pop(){
                   remove(arr[arr.length-1]);
                }
                //
                public void fill(A i) {
                	 Arrays.fill(arr,i);
                }
                //
}
      