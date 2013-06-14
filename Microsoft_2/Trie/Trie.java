import java.util.*;
import java.lang.*;
public class Trie
 	 {
             TrieNode root;
             public Trie()
             {
		 root=new TrieNode();
             } 
	     public void addword(String word)
	     {
		 root.addword( word);
             }
             public String LCP()
             {
		 List<Prefix> the_list=new ArrayList<Prefix>();
		 for(TrieNode Z : root.children)
		     {
			 if(Z!=null)
			     {
				 Prefix item=getPrefix(Z);
                                 the_list.add(item);
				 //System.out.println(item);
                             }
			 
                     }
	     Collections.sort(the_list);
	     List<String> only_prefixs=new ArrayList<String>();
             for(Prefix next :the_list)
		 {
		     if(the_list.get(the_list.size()-1).Num_Words==next.Num_Words)
			 {
			     only_prefixs.add(next.the_Prefix);
			 }
                 }
	     int max=0;
             String result="";
	     for(String item : only_prefixs)
		 {
                  max=Math.max(max,item.length());
		 
                  
		 }
	     for(String item: only_prefixs)
		 {
		    if( item.length()==max)
		      {
			  result+=" "+item;
                      }
		 }

	     return result;
	     }
             public Prefix getPrefix(TrieNode node)
	     {
		 Stack <TrieNode> DFS=new Stack<TrieNode>();
		 DFS.push(node);
		 boolean check_prefix=false;
                 int NumKids=0;
		 int Num_Words=0;
		 String prefix="";
                 while(!DFS.isEmpty())
		     {
			 TrieNode current=DFS.pop();
			
                         if(current.isWord) Num_Words++;
                          
                         for(TrieNode Z:current.children)
			     {
				 if(Z!=null)
				     {
					 DFS.push(Z);
                                         NumKids++;
                                     }
                             }
			 if(!check_prefix)
			     {
                               
				 if(NumKids<=1&& !current.isWord)
				     {
					 prefix+=current.character;
					 
				     }
				 else
				     {
                                       prefix+=current.character;
                                       check_prefix=true;
                                     }
                             }
			 NumKids=0;
                     }
                 
                 Prefix result=new Prefix();
                 result.Num_Words=Num_Words;
                 result.the_Prefix=prefix;
		 return result;
             }
              private class Prefix implements Comparable <Prefix>
	      {
		  String  the_Prefix;
                  int Num_Words;
                  public Prefix()
		      {}
                  public int compareTo (Prefix other)
                  {
                      if(this.Num_Words>other.Num_Words) return 1;
                      else if(this.Num_Words<other.Num_Words) return -1;
			      else return 0;
                       

			  //return this.Num_Words.toString().compareTo(other.Num_Words.toString());
                  }
                  public String toString()
		  {
		      return the_Prefix+" " + Num_Words;
                  }
                  
                  
	      }
               private class TrieNode
	       	       {
			 TrieNode parent;
                         char character;
                         TrieNode [] children ;
                         boolean isLeaf;
                         boolean isWord;
			 int numberofChildren;
                       public TrieNode()
                            {
                             children=new TrieNode[26];
                             isLeaf =true;
                             isWord=false;
                            }
			public TrieNode(char character)
			   {
			       this();
                               this.character=character;
                           }
                          
                         public void addword(String word)
                           { 
			       isLeaf=false;
			       
                               int pos=word.charAt(0)-'a';
                               //System.out.println(pos +" "+word.charAt(0));
                               if(children[pos]==null)
				   {
				       numberofChildren++;
				       children[pos]=new TrieNode(word.charAt(0));
                                       children[pos].parent=this;
                                       
                                   }
			       if(word.length()>1)
				   { 
				       children[pos].addword(word.substring(1));
                                   }
			       else
				   {
				      children[pos].isWord=true;
                                   }
			       
                           }
                        
                       } 
	     public static void main(String [] args)
	          {
		      Trie Dictonary=new Trie();
                      String [] the_array ={"abbout" ,"abba", "abbore","cat","catoon","cata"};
                      //String fake="";
                      // fake+="about".charAt(0);
                      for(String item : the_array)
			  {
			      Dictonary.addword(item);
                          }
		      System.out.println(Dictonary.LCP());
	          }
	 }