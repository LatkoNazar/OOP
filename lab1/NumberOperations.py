class NumberOperations:
    def __init__(self):
        self.numbers = [10, 20.5, 30, 40.7, 50, 60.3, 70, 80.1, 90, 100.9]
        self.byte_numbers = []
        self.short_numbers = []
        self.int_numbers = []
        self.float_numbers = []
        self.long_numbers = []

    def print_numbers(self):
        print("Numbers: " + ", ".join(str(x) for x in self.numbers))

    def distribute_numbers(self):
        for num in self.numbers:
            if isinstance(num, int) and num <= 127:
                self.byte_numbers.append(num)
            elif isinstance(num, int) and num <= 32767:
                self.short_numbers.append(num)
            elif isinstance(num, int):
                self.int_numbers.append(num)
            elif isinstance(num, float):
                self.float_numbers.append(num)
            else:
                self.long_numbers.append(num)

    def add_number(self, number):
        self.numbers.append(number)

    def print_float_int(self):
        ints = [int(x) for x in self.numbers]
        floats = [round(float(x), 2) for x in self.numbers]
        print("Numbers (Integers): " + ", ".join(str(x) for x in ints))
        print("Numbers (Floats): " + ", ".join(str(x) for x in floats))

    def print_byte_to_long(self):
        print("Byte numbers: " + ", ".join(str(x) for x in self.byte_numbers))
        print("Short numbers: " + ", ".join(str(x) for x in self.short_numbers))
        print("Integer numbers: " + ", ".join(str(x) for x in self.int_numbers))
        print("Long numbers: " + ", ".join(str(x) for x in self.long_numbers))
        print("Float numbers: " + ", ".join(str(x) for x in self.float_numbers))

    def sum_of_squares(self):
        sum = 0
        for el in self.numbers:
            sum += el**2
        print("Sum of squares: " + str(sum))

if __name__ == "__main__":
    num_operations = NumberOperations()
    num_operations.print_numbers()
    num_operations.distribute_numbers()
    num_operations.print_float_int()

    # Add numbers
    num_operations.add_number(127)
    num_operations.add_number(5)
    num_operations.add_number(1000)
    num_operations.add_number(928.555)
    num_operations.add_number(298)

    num_operations.distribute_numbers()
    num_operations.print_byte_to_long()
    num_operations.sum_of_squares()

