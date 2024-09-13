public class AssemblyLine
{
   // private fields
   private String assemblyName; // assembly line name
   private int totalNum; // the total number of widgets that manufactured
   private int rejectNum; // the rejected number of widgets that manufactured
   
   // constructors
   /**
      no arg constuctor
   */
   public AssemblyLine()
   {
      assemblyName = "";
      totalNum = 0;
      rejectNum = 0;
   }
   /**
      constructor that takes args
   */
   public AssemblyLine(String lineName, int total, int reject)
   {
      assemblyName = lineName;
      totalNum = total;
      rejectNum = reject;
   }
         // setters (mutator) methods
   /**
      setAssemblyName()
   */
   public void setAssemblyName(String nameGiven)
   {
      assemblyName = nameGiven;
   }
   /**
      setTotalNum()
   */
   public void  setTotalNum(int totalGiven)
   {
      totalNum = totalGiven;
   }
   /**
      setRejectNum()
   */
   public void setRejectNum(int rejectGiven)
   {
      rejectNum = rejectGiven;
   }
         // getter (accessor) methods
   /**
      getAssemblyName()
   */
   public String getAssemblyName()
   {
      return assemblyName;
   }
   /**
      getTotalNum()
   */
   public int getTotalNum()
   {
      return totalNum;
   }
   /**
      getRejectNum()
   */
   public int getRejectNum()
   {
      return rejectNum;
   }

   // other methods
   /**
      acceptable Widget
      calcAcceptable()
   */
   public double calcAcceptable()
   {
      return totalNum - rejectNum;
   }
   /**
      assembly line quality
      calcQuality
   */
   public double calcQuality()
   {
      return (calcAcceptable() / totalNum)*100;
   }


}