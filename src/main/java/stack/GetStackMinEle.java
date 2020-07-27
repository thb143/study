//package stack;
//
//public class GetStackMinEle {
//
//    MyStack elem;
//    MyStack min;
//
//    public GetStackMinEle() {
//        elem = new MyStack();
//        min = new MyStack();
//    }
//
//    // 入栈时需要考虑当前元素是否是当前栈最小元素，是的话当前元素也要压入 min 栈中    public void push(int data) {
//
//        elem.push(data);
//
//        if(min.isEmpty())
//
//            min.push(data);
//
//        else {
//
//            if(data < min.peek())
//
//                min.push(data);
//
//        }
//
//    }
//
//    //出栈时，需要判断 elem 栈顶元素是否为当前栈的最小值，是的话，min 栈顶元素也要出栈    public int pop() {
//
//        int topData = elem.peek();
//
//        elem.pop();
//
//        if(topData == this.min())
//
//            min.pop();
//
//        return topData;
//
//    }
//
//    public int min() {
//
//        if(min.isEmpty())
//
//            return Integer.MAX_VALUE;
//
//        else            return min.peek();
//
//    }
//
//}
