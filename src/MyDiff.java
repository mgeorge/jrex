//import java.util.Iterator;
//import java.util.List;
//
//import org.incava.util.diff.Diff;
//import org.incava.util.diff.Difference;
//
//
//public class MyDiff {
//
//    public MyDiff(String[] aLines, String[] bLines)
//    {
////        String[] aLines = read(fromFile);
////        String[] bLines = read(toFile);
//        List     diffs  = (new Diff(aLines, bLines)).diff();
//        
//        Iterator it     = diffs.iterator();
//        while (it.hasNext()) {
//            Difference diff     = (Difference)it.next();
//            int        delStart = diff.getDeletedStart();
//            int        delEnd   = diff.getDeletedEnd();
//            int        addStart = diff.getAddedStart();
//            int        addEnd   = diff.getAddedEnd();
//            String     from     = toString(delStart, delEnd);
//            String     to       = toString(addStart, addEnd);
//            String     type     = delEnd != Difference.NONE && addEnd != Difference.NONE ? "c" : (delEnd == Difference.NONE ? "a" : "d");
//
//            System.out.println(from + type + to);
//
//            if (delEnd != Difference.NONE) {
//                printLines(delStart, delEnd, "<", aLines);
//                if (addEnd != Difference.NONE) {
//                    System.out.println("---");
//                }
//            }
//            if (addEnd != Difference.NONE) {
//                printLines(addStart, addEnd, ">", bLines);
//            }
//        }
//    }
//
//    protected void printLines(int start, int end, String ind, String[] lines)
//    {
//        for (int lnum = start; lnum <= end; ++lnum) {
//            System.out.println(ind + " " + lines[lnum]);
//        }
//    }
//
//    protected String toString(int start, int end)
//    {
//        // adjusted, because file lines are one-indexed, not zero.
//
//        StringBuffer buf = new StringBuffer();
//
//        // match the line numbering from diff(1):
//        buf.append(end == Difference.NONE ? start : (1 + start));
//        
//        if (end != Difference.NONE && start != end) {
//            buf.append(",").append(1 + end);
//        }
//        return buf.toString();
//    }
//	
//}
