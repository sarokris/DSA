# Selection sort
> The algorithm **repeatedly selects the smallest (or largest) element from the unsorted portion of the list and swaps it with the first element of the unsorted part.** This process is repeated for the remaining unsorted portion until the entire list is sorted. 

### Time Complexity
 - The time complexity of Selection Sort is O(N2) as there are two nested loops:

- One loop to select an element of Array one by one = O(N)
Another loop to compare that element with every other Array element = O(N)
Therefore overall complexity = O(N) * O(N) = O(N*N) = O(N2)

### Auxiliary Space
-  O(1) as the only extra memory used is for temporary variables while swapping two values in Array. The selection sort never makes more than O(N) swaps and can be useful when memory writing is costly.