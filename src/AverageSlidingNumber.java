void main() {
    var numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    var batch = 5;
    var sligingList = numbers.stream()
            .gather(Gatherers.windowSliding(batch))
            .toList();

    System.out.println("Batch of Sliding list :: " + sligingList);

    var averageList = sligingList.stream()
            .map(num -> num.stream()
                    .mapToDouble(Integer::doubleValue)
                    .average()
                    .getAsDouble())
            .toList();

    System.out.println("Average of all the sliding list :: " + averageList);

    /**
     * OUTPUT
     * Batch of Sliding list :: [[1, 2, 3, 4, 5], [2, 3, 4, 5, 6], [3, 4, 5, 6, 7], [4, 5, 6, 7, 8], [5, 6, 7, 8, 9], [6, 7, 8, 9, 10]]
     * Average of all the sliding list :: [3.0, 4.0, 5.0, 6.0, 7.0, 8.0]
     **/
}
