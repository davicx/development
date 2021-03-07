import datetime
import string

date_one = "7th Apr 2020"
date_two = "22nd Jan 2013"
date_three = "1st Mar 1994"


#Output 2020-04-07
def main():

  #Create our Date to Convert  
  date_string = list(date_three.split(" ")) 
  day_raw = date_string[0]
  month_raw = date_string[1] 
  year_raw = date_string[2] 

  day = day_format(day_raw)
  month = month_format(month_raw)
  year = year_format(year_raw)

  print(day, " ", month, " ", year)  
  d = datetime.date(year, day, month)
  print(d)
  #datetime.datetime(year=year,month=month,day=day,hour=hour)


def day_format(day_raw):
  parseDate = RemoveDateChar()
  cleaned_day = int(day_raw.translate(parseDate))
  return cleaned_day

def month_format(month_raw):
  datetime_object = datetime.datetime.strptime(month_raw, "%b")
  month_number = datetime_object.month
  return month_number 

def year_format(year_raw):
  year = int(year_raw)
  return year


class RemoveDateChar:
  def __init__(self, keep=string.digits):
    self.comp = dict((ord(c),c) for c in keep)
  def __getitem__(self, k):
    return self.comp.get(k)


if __name__ == "__main__":
    main()
 

 


"""

#Get the Month as a Number 
def get_month_number(month_name):
    datetime_object = datetime.datetime.strptime(month_name, "%b")
    month_number = datetime_object.month
    print(month_number) 

month_name = "Mar"
get_month_number(month_name)

#Remove the Chars from the Day 
parseDate = RemoveDateChar()
date_string = list(date_three.split(" ")) 
day = date_string[0].translate(parseDate)
month = date_string[1] 
year = date_string[2] 

#d = datetime.date(year, month, day)
d = datetime.date(2020, 4, 21)
#print(day, " ", month, " ", year)
#print(d)
"""