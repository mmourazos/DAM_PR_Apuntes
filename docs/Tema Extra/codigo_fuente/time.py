from datetime import datetime
from time import strftime

dt = datetime(2020, 11, 4, 14, 53, 0)

print(dt.strftime('%Y/%m/%d %H:%M:%S'))
print(dt.strftime('%y/%B/%d %H:%M:%S %p'))
print(dt.strftime('%a, %Y %b %d'))
print(dt.strftime('%A, %Y %B %d'))
print(dt.strftime('Weekday: %w'))
print(dt.strftime('Day of the year: %j'))
print(dt.strftime('Week number of the year: %W'))


print(dt)

x = lambda a, b: a ** b
print(x(1, 2))

import os

print(os.listdir())

from datetime import date

date_1 = date(1992, 1, 16)
date_2 = date(1991, 2, 5)

print (date_1 - date_2)

import calendar

print(calendar.weekheader(2))

b = bytearray(3)

print(b)

print(list(filter(lambda x: x-0 and x-1, (0, 1, 2, 3, 4, 5, 6))))

x = 0
print(1 and 2)

float(".1")

print(__name__)

for line in open('mkdocs.yml', 'rt'):
    print(line)
    