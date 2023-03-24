class Interval:
    
    def __init__(self, hours: int = 0, minutes: int = 0, seconds: int = 0) -> None:
        self.h = hours
        self.m = minutes
        self.s = seconds
     
    def __add__(self, other: 'Interval') -> 'Interval':
        
        seconds = self.s + other.s
        extra_min = seconds // 60
        seconds = seconds % 60
        
        minutes = self.m + other.m + extra_min
        extra_hours = minutes // 60
        minutes = minutes % 60
        
        hours = self.h + other.h + extra_hours
        return Interval(hours, minutes, seconds)
    
    def __sub__(self, other: 'Interval') -> 'Interval':
        if (self.seconds() <= other.seconds()): return Interval(0, 0, 0)
        
        seconds = self.s - other.s
        minutes = self.m - other.m
        hours = self.h - other.h
        
        if seconds < 0:
            minutes -= 1
            seconds += 60
            
        if minutes < 0:
            hours -= 1
            minutes += 60
            
        return Interval(hours, minutes, seconds)
    
    def seconds(self) -> int:
        return self.s + self.m * 60 + self.h * 3600
    
    def __str__(self) -> str:
        return f'{str(self.h).zfill(2)}:{str(self.m).zfill(2)}:{str(self.s).zfill(2)}'
    
int_1 = Interval(6, 5, 5)
print(int_1)
int_2 = Interval(5, 5, 6)
print(int_2)

print(int_1 - int_2)