class Solution {

    public List<List<String>> accountsMerge(
            List<List<String>> accounts) {

        Map<String, List<String>> graph = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();

        // Build graph
        for (List<String> account : accounts) {

            String name = account.get(0);
            String firstEmail = account.get(1);

            graph.putIfAbsent(firstEmail, new ArrayList<>());
            emailToName.put(firstEmail, name);

            for (int i = 2; i < account.size(); i++) {

                String email = account.get(i);

                graph.putIfAbsent(email, new ArrayList<>());
                emailToName.put(email, name);

                // Connect first email with current email
                graph.get(firstEmail).add(email);
                graph.get(email).add(firstEmail);
            }
        }

        Set<String> visited = new HashSet<>();

        List<List<String>> result = new ArrayList<>();

        // Find connected components
        for (String email : graph.keySet()) {

            if (visited.contains(email)) {
                continue;
            }

            List<String> emails = new ArrayList<>();

            dfs(email, graph, visited, emails);

            Collections.sort(emails);

            List<String> account = new ArrayList<>();

            account.add(emailToName.get(email));
            account.addAll(emails);

            result.add(account);
        }

        return result;
    }

    private void dfs(
            String email,
            Map<String, List<String>> graph,
            Set<String> visited,
            List<String> emails) {

        visited.add(email);
        emails.add(email);

        for (String neighbor : graph.get(email)) {

            if (!visited.contains(neighbor)) {
                dfs(neighbor, graph, visited, emails);
            }
        }
    }
}