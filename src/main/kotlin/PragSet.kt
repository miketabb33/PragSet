package io.michael

class PragSet {
    private var size = 0
    private var currentMax = 1
    private var array = IntArray(currentMax)

    fun insert(item: Int) {
        val itemExistsInArray = findIndex(item) != -1
        if(itemExistsInArray) { return }

        if(size >= currentMax) {
            array = getExpandedArrayCopy()
        }

        array[size] = item
        size++
    }

    fun contains(item: Int): Boolean {
        return findIndex(item) != -1
    }

    fun isEmpty(): Boolean {
        return size == 0
    }

    fun size(): Int {
        return size
    }

    fun findIndex(item: Int): Int {
        for (i in 0 until size) {
            if (array[i] == item) {
                return i
            }
        }
        return -1
    }

    fun remove(item: Int) {
        size--

        val indexToRemove = findIndex(item)
        val itemToSwap = array[size]

        array[indexToRemove] = itemToSwap
        array[size] = item
    }

    fun clear() {
        size = 0
    }

    fun printAllocations() {
        print(currentMax)
    }

    fun printSet() {
        print(size)
    }

    private fun print(count: Int) {
        print('[')
        for (i in 0 until count) {
            print("${array[i]},")
        }
        print("]\n")
    }

    private fun getExpandedArrayCopy(): IntArray {
        currentMax = (currentMax + 3) * 2
        val expandedArray = IntArray(currentMax)

        for (i in 0 until size) {
            expandedArray[i] = array[i]
        }

        return expandedArray
    }
}