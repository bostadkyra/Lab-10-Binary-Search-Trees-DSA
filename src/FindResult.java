public class FindResult {
    private final boolean found;
    private final int nodesVisited;

    public FindResult(boolean found, int nodesVisited){
        this.found = found;
        this.nodesVisited = nodesVisited;
    }

    public boolean getFound(){
        return found;
    }

    public int getNodesVisited(){
        return nodesVisited;
    }
}
