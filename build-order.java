/**Given a list of projects and a list of dependencies (which is a list of pairs of projects, where the first project is depedent on teh second preojct). 
All of a proejct's depedencies must be built before the proejct is. Find the build order that will allow the projects to be built. 
IF there is no valid build order, return an error.
Input: 
Projects: a, b, c, d, e, f
Dependencies: (d, a), (b, f), (d, b), (a, f), (c, d)
Output: f, e, a, b, d, c
**/
public class Solution {
    public class Project {
        ArrayList<Project> children = new ArrayList<Project>();
        HashMap<String, Project> nameMap = HashMap<String, Project>();
        int dependencies;
        String name;
        public Project(String name) {
            this.name = name;
        }
        public void addDependency(Project node) {
            if (!nameMap.containsKey(node.name)) {
                children.add(node);
                dependencies++;
            }
        }
    }
    public class Graph {
        ArrayList<Project> nodes = new ArrayList<Project>();
        HashMap<String, Project> nameMap = new HashMap<String, Project>();
        public void addEdge(String start, String end) {
            Project startProject = getOrCreateNode(start);
            Project endProject = getOrCreateNode(end);
            startProject.addDependency(endProject);
        }
        public Project getOrCreateNode(String name) {
            if (!nameMap.containsKey(name)) {
                Project newProject = new Project(name);   
                nameMap.put(name, newProject);
                nodes.add(newProject);
            }
            return nameMap.get(name);
        }
    }
    public class Solution {
        public Graph buildGraph(String[] projects, String[][] dependencies) {
            Graph graph = new Graph();
            for (String project : projects) graph.getOrCreateNode(project);
            for (String[] dependency : dependencies) {
                graph.addEdge(dependency[0], 
            }
        }
        public static void main(String args[]) {
               
        }
    }
}
