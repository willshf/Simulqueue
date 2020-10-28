/**
 * Simuliert eine Queue durch Stacks
 */
public class SimulQueue<ContentType> {
   /** Attribute der Klasse SimulQueue **/
   private Stack<ContentType> stackA = new Stack<ContentType>(); 
   private Stack<ContentType> stackB = new Stack<ContentType>();
   
   /** Methoden der Klasse SimulQueue **/
   public SimulQueue() {
   }
   
   /**
    * Fügt ein Element der Warteschlange hinzu
    */
   public void enqueue(ContentType pObject) { 
       stackA.push(pObject);
   }
   
   /**
    * Entfernt das erste Element aus der Warteschlange
    */
   public void dequeue() {
       reverse(stackA, stackB);
       stackA.pop();
       reverse(stackB, stackA);
   } 
   
   /**
    * Dreht StackToReverse auf den cacheStack um
    */
   private void reverse(Stack StackToReverse, Stack cacheStack) {
       while (StackToReverse.isEmpty() == false) {
           cacheStack.push(StackToReverse.top());
           StackToReverse.pop();
       }
   }
   
   /**
    * Gibt das erste Element der Warteschlange zurück
    * 
    * @return ContentType
    */
   public ContentType front() {
       if (stackA.isEmpty() == false) {
           reverse(stackA, stackB);
           ContentType rueckgabe = stackB.top();
           reverse(stackB, stackA);
           return rueckgabe;
       }
       else {       
           return null; 
       }
   }
}
