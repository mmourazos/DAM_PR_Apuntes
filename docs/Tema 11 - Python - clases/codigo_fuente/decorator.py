import time
from datetime import datetime
from typing import Callable
def simple_hi():
    print('Hi world!')
    
def hi_decorator(function: Callable) -> Callable:
    print(f'We are about to call {function.__name__}')
        
    return function

hi_decorator(simple_hi)()


def timestamper(function):
    print(datetime.now().strftime('%Y-%m-%d %H:%M:%S'))
    return function


raise Exception