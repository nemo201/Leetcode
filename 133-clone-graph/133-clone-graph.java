/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> neighbors;
    Node() {
        val = 0;
        neighbors = vector<Node*>();
    }
    Node(int _val) {
        val = _val;
        neighbors = vector<Node*>();
    }
    Node(int _val, vector<Node*> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/

class Solution {
public:
    unordered_map<Node*, Node*> map;
    Node* cloneGraph(Node* node) {
        if (!node)
            return NULL;
        
        return dfs(node);
    }
    
    Node* dfs(Node* node) {
        if(map[node])
            return map[node];
        Node* copy = new Node(node->val);
        map[node] = copy;
        
        for (Node* nei : node->neighbors) {
            copy->neighbors.push_back(dfs(nei));
        }
        return copy;
    }
};

// class Solution {
// public:
//     Node* cloneGraph(Node* node) {
//         if (!node)
//             return NULL;
//         Node* copy = new Node(node->val, {});
//         copies[node] = copy;
//         queue<Node*> todo;
//         todo.push(node);
//         while(!todo.empty()) {
//             Node* cur = todo.front();
//             todo.pop();
//             for(Node* neig : cur-> neighbors) {
//                 if (copies.find(neig) == copies.end()) {
//                     copies[neig] = new Node(neig -> val, {});
//                     todo.push(neig);
//                 }
//                 copies[cur]->neighbors.push_back(copies[neig]);
//             }
//         }
//         return copy;
//     }
// private:
//     unordered_map<Node*, Node*> copies;
// };