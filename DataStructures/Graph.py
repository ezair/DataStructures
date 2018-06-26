'''
Author:	Eric Zair
File:	Graph.py
Description:	This is a quick implementation of a graph
				data structure in python3.
				This graph class will be used to test out a
				bunch of bfs and dfs algorithms.
				These algorithms include linkstate and distance vector.
'''
from collections import defaultdict


#This is the graph class that will be used to test out algorithms on.
class Graph(object):

    #Constructor
    def __init__(self, connections, directed=False):
        self.graph = defaultdict(set)
        self.directed = directed
        self.addConnections(connections)


    #add the connections to the graph in pairs of 2.
    #parameters: connections (list of tuples)
    def addConnections(self, connections):
        for node1, node2 in connections:
            self.add(node1, node2)


    #Add connection between node1 and node2.
    #If the graph is directed, both nodes add eachother.
    def add(self, node1, node2):
        self.graph[node1].add(node2)
        if not self.directed:
            self.graph[node2].add(node1)


    #Take a node out of the graph.
    def remove(self, node):
        for n, cxns in self.graph.iteritems():
            try:
                cxns.remove(node)
            except keyError:
                pass
        try:
            del self.graph[node]
        except keyError:
            pass

    #return true if a node is connected to another node.
    def isConnected(self, node1, node2):
        return node1 in self.graph and node2 in self.graph[node1]

    #The 2string of the graph object.
    def __str__(self):
        return '{}({})'.format(self.__class__.__name__, dict(self.graph))


#test class
connections = [ ('Eric', 'Jesse'), ('matti', 'jason'), ('Eric', 'matti'), ('Eric', 'jason'), ('jason', 'jesse') ]
graph = Graph(connections, directed=True)
print(graph)