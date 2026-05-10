import unittest
from enum import unique

from university1 import StudentRecords

class MyTestCase(unittest.TestCase):

    def setUp(self):
        self.student_records = StudentRecords()
        self.student_records.add_student(
            {"name": "John Paul",
             "age": 21,
             "courses": {"Math", "Physics", " Computer Science"},
             "address": {"city": "Lagos", "zip-code": 411}},
            "Ova")

    def test_record_system_is_empty_when_created(self):
        self.assertFalse(self.student_records.is_empty())

    def test_record_system_is_not_empty_when_created(self):
        self.assertFalse(self.student_records.is_empty())

    def test_record_system_returns_the_total_number_of_students_in_university(self):
        self.student_records.add_student(
            {"name": "John Paul", "age": 21, "courses": {"Math", "Physics", " Computer Science"},
             "address": {"city": "Lagos", "zip-code": 411}}, "Ola")
        self.assertEqual(self.student_records.get_total_student(),len(self.student_records))


    def test_add_one_more_record_number_of_records_in_system_increases_by_one(self):
        self.assertEqual(len(self.student_records), self.student_records.get_total_student())
        self.student_records.add_student({"name": "John Paul", "age":21,"courses":{"Math", "Physics"," Computer Science"},"address":{"city":"Lagos","zip-code":411}},"Ola")
        self.assertEqual(len(self.student_records),self.student_records.get_total_student())

    def test_age_field_of_target_student_changes_from_21_to_30_when_age_is_updated(self):
        unique_id = "Ova"
        self.assertTrue(self.student_records.get_total_student()==1)
        self.assertEqual(self.student_records.records[unique_id]["age"], 21)
        self.student_records.update_record(unique_id,{"age": 90})
        self.assertEqual(self.student_records.records[unique_id]["age"],90)







if __name__ == "__main__":
    unittest.main()