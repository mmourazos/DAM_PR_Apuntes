import os

def find(path: str, dir: str = "") -> bool:
    for dir_entry in os.scandir(path):
        if dir_entry.name == dir and os.path.isdir(dir_entry): return True
    return False

dir = '/'
sub_dir = '.GamingRoot'
print(f'¿Hay {sub_dir} en {dir}? -> {find(dir, sub_dir)}')