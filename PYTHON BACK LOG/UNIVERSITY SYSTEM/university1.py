class StudentRecords:

    def __init__(self):
        self.records = {}

    def __len__(self):
        return len(self.records)

    def is_empty(self):
        return len(self.records) == 0

    def add_student(self, dictionary, unique_id):
        student_id = unique_id
        self.records[student_id] = dictionary

    def get_total_student(self):
        return len(self.records)

    def update_record(self, unique_id, updates):
        self.records[unique_id].update(updates)






