package com.example.algorithm1spring;

import java.util.Arrays;

public class IntegerListRealization {
    private Integer[] storage;
    private int size;

    public IntegerListRealization() {
        this.storage = new Integer[10];
    }

    public IntegerListRealization(int initSize) {
        this.storage = new Integer[initSize];
    }


    public Integer add(Integer item) {
        growIfNeeded();
        validateItem(item);
        storage[size++] = item;
        return item;
    }


    public Integer add(int index, Integer item) {
        growIfNeeded();
        validateItem(item);
        validateIndex(index);
        if (index == size) {
            storage[size++] = item;
            return item;
        }
        System.arraycopy(storage, index, storage, index + 1, size - index);
        storage[index] = item;
        size++;
        return item;
    }


    public Integer set(int index, Integer item) {
        validateIndex(index);
        validateItem(item);
        storage[index] = item;
        return item;
    }


    public Integer remove(Integer item) {
        validateItem(item);
        int index = indexOf(item);
        return remove(index);
    }


    public Integer remove(int index) {
        validateIndex(index);
        Integer item = storage[index];
        if (index != size) {
            System.arraycopy(storage, index + 1, storage, index, size - index);
        }
        size--;
        return item;
    }


    public boolean contains(Integer item) {
        Integer[] storageCopy = toArray();
        sort(storageCopy);
        return binarySearch(storageCopy, item);
    }


    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            Integer s = storage[i];
            if (s.equals(item)) {
                return i;
            }
        }
        return -1;
    }


    public int lastIndexOf(Integer item) {
        for (int i = size - 1; i >= 0; i--) {
            Integer s = storage[i];
            if (s.equals(item)) {
                return i;
            }
        }
        return -1;
    }


    public Integer get(int index) {
        validateIndex(index);
        return storage[index];
    }


    public boolean equals(StringList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }


    public int size() {
        return size;
    }


    public boolean isEmpty() {
        return size == 0;
    }


    public void clear() {
        size = 0;
    }


    public Integer[] toArray() {
        return Arrays.copyOf(storage, size);
    }

    private void validateItem(Integer item) {
        if (item == 0) {
            throw new NullItemException();
        }
    }

    private void growIfNeeded() {
        if (size == storage.length) {
           grow();
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index > size) {
            throw new InvalidIndexException();
        }
    }

    private void sort(Integer[] arr) {
        quickSort(arr, 0, arr.length -1);
    }

    private void quickSort(Integer[] arr, int begin, int end) {   /////Рекурсивный метод Быстрой сортировки
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private int partition(Integer[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                swapElements(arr, i, j);
            }
        }

        swapElements(arr, i + 1, end);
        return i + 1;
    }

    private void swapElements(Integer[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private boolean binarySearch(Integer[] arr, Integer item) {
        int min = 0;
        int max = arr.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (item == arr[mid]) {
                return true;
            }

            if (item < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    private void grow() {
        storage = Arrays.copyOf(storage, size + size / 2);
    }
}
