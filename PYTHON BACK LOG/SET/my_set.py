from itertools import count


class MySet:

    def __init__(self):
        self.my_list = []

    def __len__(self):
        return len(self.my_list)

    def is_empty(self):

        return len(self.my_list)==0

    def contains(self, element):

        for value in self.my_list:
            if value==element:
                return True
        return False

    def add(self, element):
        if not self.contains(element):
            self.my_list.append(element)

    def remove(self, element):
        if self.contains(element):
            self.my_list.pop(self.my_list.index(element))
        else:
            raise KeyError("Element no found")

    def union(self, another_set):
        new_list = self.my_list.copy()
        for value in another_set:
            if not self.contains(value):
                new_list.append(value)
        return len(new_list)

    def intersection(self, another_set):
        new_list = []
        for value in another_set:
            if self.contains(value):
                new_list.append(value)
        return len(new_list)











