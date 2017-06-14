/**Given a list of projects and a list of dependencies (which is a list of pairs of projects, where the first project is depedent on teh second preojct). 
All of a proejct's depedencies must be built before the proejct is. Find the build order that will allow the projects to be built. 
IF there is no valid build order, return an error.
Input: 
Projects: a, b, c, d, e, f
Dependencies: (d, a), (b, f), (d, b), (a, f), (c, d)
Output: f, e, a, b, d, c
**/
