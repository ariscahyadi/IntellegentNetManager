# IntellegentNetManager (Intellegent Networking Manager)

by Aris C. Risdianto - [aris.risdianto@gmail.com] (mailto:aris.risdianto@gmail.com)

## Introduction

This tool is part of my project for solving current networking path selection which always based on the cost of the links or available bandwidth between nodes, without considering passive information or parameters such as logs or alarms from respective nodes. This tool is similar with current path selection, but it will decide by the node state, and the node weight based of the event generated by the agent for respective node. Finallt, it will do a dynamic path selection based on shortest path algorithm.

## Design

In order to design the tool, some solution approaches or methodologies have been identified

1. Modified Shortest Path Algorithm, for considering link cost and weight node for shortest path calculation
2. Optimal Heuristic Definition or Value Assignment, for deciding only specific number of events can change the node state, based on number of neighbor/adjacencies of the network node

## Implementation

To implement the design simple data format and algorithm are selected:

1. Integer Array for simple database to store node weight which required for dynamic path calculation by the modified Dijkstra SPF algorithm.
2. Modified Dijkstra SPF Algorithm for SPF path calculation which not only considering the cost of edges, but also considering the weight of the vertices

## Verification

As the initial condition (all the nodes weight and link cost are equal to one), the agent manager will select the less nodes for the path (ex. v0 – v1 – v4) because that is the lowest cost to reach vertex 4 from vertex 0. But after vertex 1 change the weight because of several event are received from agent in the vertex 1, the agent manager change the path into more nodes (ex. v0 – v2 – v3 – v4), but based on the shortest path re-calculation that path is shortest.
