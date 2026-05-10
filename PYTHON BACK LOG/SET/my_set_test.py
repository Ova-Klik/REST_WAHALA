import unittest
from my_set import MySet


class TestClass(unittest.TestCase):

    def setUp(self):
        self.our_set = MySet()

    def test_that_a_new_set_is_empty(self):
        self.assertTrue(self.our_set.is_empty())

    def test_add_one_element_set_is_not_empty(self):
        self.our_set.add(23)
        self.assertFalse(self.our_set.is_empty())

    def test_set_does_not_add_duplicate_element(self):
        self.our_set.add(23)
        self.our_set.add(23)
        self.assertEqual(len(self.our_set), 1)

    def test_remove_set_element_set_length_is_reduced_When_element_is_removed(self):
        self.our_set.add(23)
        self.our_set.add(24)
        self.our_set.remove(24)
        self.assertEqual(len(self.our_set), 1)

    def test_remove_element_raise_error_when_element_not_in_set(self):
        self.our_set.add(23)
        self.assertRaises(KeyError,lambda: self.our_set.remove(24))

    def test_union_of_two_set_gives_one_set_of_all_elements_contained(self):
        self.our_set.add(23)
        self.our_set.add(24)
        another_set = {25,56}
        expected =self.our_set.union(another_set)
        self.assertEqual(expected, 4)

    def test_intersection_of_two_set_gives_one_set_of_common_element(self):
        self.our_set.add(23)
        self.our_set.add(24)
        another_set = {23,56}
        expected =self.our_set.intersection(another_set)
        self.assertEqual(expected, 1)

    # def test_difference_of_two_set_gives_a_set_uncommon_element(self):








































if __name__ == '__main__':
    unittest.main()
