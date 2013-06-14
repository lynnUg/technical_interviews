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
             public void LCP()
             {
		 for(TrieNode Z : root.children)
		     {
			 if(Z!=null)
			     {
				 String [] PrefixAndNumOfWords=Prefix(Z);
                             }
                     }
	     }
             public String [] Prefix(TrieNode node)
	     {
		 Stack <TrieNode> DFS=new Stack<TrieNode>();
		 DFS.push(node);
		 int Num_Words=0;
		 String prefix="";
                 while(!DFS.isEmpty())
		     {
			 TrieNode current=DFS.pop();
                         if(current.isWord()) Num_Words++;
                         if(current.numberofChildren==1) prefix+=current.character;
                         for(TrieNode Z:current.children)
			     {
				 if(Z!=null)
				     {
					 DFS.push(Z);
                                     }
                             }
                             
                     }
                 String [] result={"",""};
                 result[0]+=Num_Words;
                 result[1]+=prefix;
		 return result;
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
			       numberofChildren++;
                               int pos=word.charAt(0)-'a';
                               if(children[pos]==null)
				   {
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
                      String [] the_array ={"about" ,"abba", "abore","cat"};
                      //String fake="";
                      // fake+="about".charAt(0);
                      for(String item : the_array)
			  {
			      Dictonary.addword(item);
                          }
	          }
	 }