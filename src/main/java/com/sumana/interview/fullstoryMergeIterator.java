package com.sumana.interview;

import java.util.*;

public class fullstoryMergeIterator {
    public static void main(String[] args) {

        Iterator<Integer> i1 = List.of(0, 1, 1, 2, 4, 13).iterator();
        Iterator<Integer> i2 = Collections.emptyIterator();
        Iterator<Integer> i3 = List.of(0, 3, 3, 5).iterator();
        Iterator<Integer> i4 = List.of(0, 1, 6, 10, 12).iterator();
        Iterator<Integer> i5 = List.of(56).iterator();

        Iterator<Integer> mergeIterator = new MergeIterator(List.of(i5, i1, i2, i3, i4));

        var sj = new StringJoiner(",", "[", "]");
        while (mergeIterator.hasNext()) {
            sj.add(mergeIterator.next().toString());
        }

        System.out.println(sj);
    }
}

class MergeIterator implements Iterator<Integer> {
    private List<Iterator<Integer>> iterators;
    private Map<Integer, Integer> headMap;

    public MergeIterator(List<Iterator<Integer>> iterators) {
        this.iterators = new ArrayList<>(iterators);
        this.headMap = new HashMap<>();
        updateHeads();
    }

    @Override
    public boolean hasNext() {
        return !headMap.isEmpty();
    }

    @Override
    public Integer next() {
        return getMinHead();
    }

    private void updateHeads() {
        for (int i = 0; i < iterators.size(); i++) {
            var currentIterator = iterators.get(i);
            try {
                if (!headMap.containsKey(i)) {
                    var currValue = currentIterator.next();
                    if (currValue != null) {
                        headMap.put(i, currValue);
                    }
                }
            } catch (NoSuchElementException e) {
                iterators.remove(i);
            }
        }
    }

    private Integer getMinHead() {
        if (!headMap.isEmpty()) {
            Set<Map.Entry<Integer, Integer>> entrySet = headMap.entrySet();

            Optional<Map.Entry<Integer, Integer>> minEntry = entrySet.stream().min(Map.Entry.comparingByValue());
            if (minEntry.isPresent()) {
                var minVal = minEntry.get().getValue();
                var minKey = minEntry.get().getKey();
                headMap.remove(minKey);
                updateHeads();
                return minVal;
            }
        }

        return null;
    }
}

