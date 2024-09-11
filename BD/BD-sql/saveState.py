import subprocess


host = 'localhost'
port = 3306
username = 'root'
password = 'Jonyguga29'
database = 'mydb'

from datetime import datetime
current_datetime = datetime.now().strftime('%Y%m%d_%H%M%S')
backup_file = f'backup_{current_datetime}.sql'


subprocess.run(['mysqldump', '-h', host, '-P', str(port), '-u', username,
                '-p' + password, database, '--result-file=' + backup_file])
