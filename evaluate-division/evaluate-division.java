public class Pair{
    int index;
    double val;
    public Pair(int index,double val){
        this.index = index;
        this.val = val;
    }
}
class Solution {
LinkedList<Pair>[] adj;
public double DFS(int index,int end,boolean[] tracker){
    //If pointer reached to the destination then return 1
    if(index==end){
        return 1;
    }
    double ans = -1;
    tracker[index]=true;
    Iterator<Pair> i = adj[index].listIterator();
    while(i.hasNext()){
        Pair n = i.next();
        
        if(!tracker[n.index]){
            double t = DFS(n.index,end,tracker);
            if(t>=0){
                ans=t*n.val;
            }
        }
    }
    return ans;
}
public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
    Set<String> set = new HashSet<>();
    Map<String,Integer> m = new HashMap<>();
    //Stsore the unique strings
    for(List<String> i : equations){
        set.add(i.get(0));
        set.add(i.get(1));
    }
    //Used linkedlist for making the graph
    adj = new LinkedList[set.size()];
    //Intialize the linkedlist
    for(int i=0;i<set.size();i++){
        adj[i] = new LinkedList();
    }
    int in=0;
    //Indexing each string uniquely
    for(String i : set){
        m.put(i,in++);
    }
    int j=0;
    //After indexing the strings, now taking each equation and making the graph(example: (start)->(next,val),(0)->(1,2.0) && (next)->(start,1/val),(1)->(0,1/2.0))
    for(List<String> i : equations){
        adj[m.get(i.get(0))].add(new Pair(m.get(i.get(1)),values[j]));
        adj[m.get(i.get(1))].add(new Pair(m.get(i.get(0)),(1/values[j])));
        j++;
        
    }
    //Used to store the answer
    double[] ans = new double[queries.size()];
    int Qindex = 0;
    for(List<String> q : queries){
        Set<String> temp = new HashSet(q);
        if(set.containsAll(temp)){
            boolean[] tracker = new boolean[set.size()];
            //Calling the DFS
            ans[Qindex]=DFS(m.get(q.get(0)),m.get(q.get(1)),tracker);
            
        }
        else{// If any of query string is not present then puting -1
            ans[Qindex]=-1.0;
        }
        Qindex++;
    }
    return ans;
}
}