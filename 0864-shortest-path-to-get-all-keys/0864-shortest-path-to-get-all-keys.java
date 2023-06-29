class Solution {        
    public int addKey(int keys, char key) {
        int keyId = 1 << (key - 'a');
        return keys | keyId;
    }
    public boolean isOpen(int keys, char lock) {
        int lockId = 1 << (lock - 'A');
        return (keys & lockId) > 0;
    } 
    public int shortestPathAllKeys(String[] grid) {
        int[] dr = new int[]{ 1,-1, 0, 0};
        int[] dc = new int[]{ 0, 0, 1,-1};
        int rows = grid.length;
        int cols = grid[0].length();
        int points = rows * cols;
        int allKeys = 0;
        int startPoint = 0;
        for(int r = 0; r < rows; r++) { // searching start point and all keys
            String row = grid[r];
            for(int c = 0; c < cols; c++) {
                char v = row.charAt(c);
                if(v == '@') startPoint = r * cols + c; // zip start row and col in a integer
                boolean isKey = v >= 'a' && v <= 'f';
				//collect the keys,allKeys will have 1bit per key starting from most right,allKeys is final state we are looking for
                if(isKey) allKeys = (allKeys << 1) | 1;  //ex: 6 keys ...0000111111, 2 keys ...0000000011
            }
        }
        int states = points * (allKeys + 1); // total possbile number of states
        int[] queue = new int[states];
        int queueHead = 0;
        int queueTail = 0;
        boolean[] visited = new boolean[states];
        int distance = 0; // starting with 0 distance
        int noKeys = 0; // starting with 0 keys, bits .. 00000000 al zero, final should be allKeys ..000111111 if we have 6 keys
        int startState = noKeys * points + startPoint; // zip point and keys in a integer
        queue[queueHead++] = startState; // push starting point in queue
        visited[startState] = true;
        while(true) {
            int size = queueHead - queueTail; // number of elements to process per breath
            if(size == 0) break;
            while(--size >= 0) {
                int state = queue[queueTail++]; // poll a state from queue
                int keys = state / points; // unzip keys state
                int point = state % points; // unzip point state
                int row = point / cols; // unzip row state
                int col = point % cols; //unzip column state
                
                if(keys == allKeys) return distance; // check if we could find all keys, if yes we stop the algorithm
                
                for(int i = 0; i < 4; i++) { // try to go over all 4 directions, left, rigth, top, bottom
                    int nextRow = row + dr[i]; // compute next row
                    int nextCol = col + dc[i];  // compute next col
					// if we are out of matrix , skip this row,col
                    if(nextRow < 0 || nextCol < 0|| nextRow >= rows || nextCol >= cols) continue; 
                    char v = grid[nextRow].charAt(nextCol);
                    if(v == '#') continue; // a wall , skip this row,col
                    int nextKey = keys;
                    if(v != '.') {
                        boolean isLock = v >= 'A' && v <= 'F';
                        if(isLock && !isOpen(keys, v)) continue; // is a lock and we do not have a key for it, skip row,col
                        boolean isKey = v >= 'a' && v <= 'f';
                        if(isKey) nextKey = addKey(nextKey, v); // is a key, add the key to allKeys collection
                    }
                    int nextPoint = nextRow * cols + nextCol; // zip back nextRow and nextCol to a integer
                    int nextState = nextKey * points + nextPoint; // zip back current keys we have and point to a integer
                    if(!visited[nextState]) {  // already visited this state, no need to go again 
                        queue[queueHead++] = nextState; // push to queue next unvisited state
                        visited[nextState] = true; // mark this state as visited
                    }
                }
            }
            distance++; // next distance
        }
        for(int i = 0; i<1000; ++i); // for some reason it makes leetcode run faster
        return -1; // we could not find desired state allkeys, so return -1
    }
}