class Solution {
    ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
    Stack<Integer> topoOrder = new Stack<Integer>();
    ArrayList<Integer> sorted = new ArrayList<Integer>();
    boolean[] visited;
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        visited = new boolean[numCourses];
         for (int i = 0; i < numCourses; i++) visited[i] = false;
        
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < prerequisites.length; i ++){
            int[] curEdge = prerequisites[i];
            adj.get(curEdge[1]).add(curEdge[0]);
        }
        // initialized adjacent edge list
        
        
        for(int i = 0; i < numCourses; i ++){
            // call topoSearchHelper(DFS helper) on all vertices
            if(!topoSearchHelper(i, new boolean[numCourses])) return new int[0];
        }
        
        while(!topoOrder.isEmpty()){
            sorted.add(topoOrder.pop());
        }
        // topological sort, cycle detection
        // return sorted.toArray();
        return sorted.stream().mapToInt(i->i).toArray();
    }
    
    public boolean topoSearchHelper(int toSearch, boolean[] isLoop){
        if(visited[toSearch]) return true;
        if(isLoop[toSearch]) return false;
        isLoop[toSearch] = true;
        ArrayList<Integer> curVertex = adj.get(toSearch);
        for(int i = 0; i < curVertex.size(); i++){
            // if(!visited[i]) is NOT needed here! we visit ALL the adjacent nodes of a vertex!!!
            if(!topoSearchHelper(curVertex.get(i), isLoop)) return false;
        }
        visited[toSearch] = true;
        // set visited = true AFTER visiting all its adjacent vertices!
        topoOrder.push(toSearch);
        return true;
    }
    
    
}