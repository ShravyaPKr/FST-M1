# Test for Addition
def test_addition():
    num1 = 20
    num2 = 15
    sum_total = num1 + num2
    print(sum_total)
    assert sum_total == 35


# Test for Subtraction
def test_subtraction():
    num1 = 50
    num2 = 25

    diff = num1 - num2
    print(diff)
    assert diff == 25


# Test for Multiplication
def test_multiplication():
    num1 = 5
    num2 = 5

    prod = num1 * num2
    print(prod)
    assert prod == 25


# Test for Division
def test_division():
    num1 = 100
    num2 = 4

    quot = num1 / num2
    print(quot)
    assert quot == 25
