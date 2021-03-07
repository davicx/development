import datetime
import string
import re

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

  date_helper = DateHelper()
  day = date_helper.day_format(day_raw)
  month =date_helper.month_format(month_raw)
  year =date_helper.year_format(year_raw)


  #print(day, " ", month, " ", year)  
  d = datetime.date(year, day, month)
  #print(d)

  a_string = "3rd"

  numeric_string = re.sub("[^0-9]", "", a_string)
  print(numeric_string)
  #parseDate = RemoveDateChar()
  #cleaned_day = int(date_raw.translate(parseDate))
  

  





class RemoveDateChar:
  def __init__(self, keep=string.digits):
    self.comp = dict((ord(c),c) for c in keep)

  def __getitem__(self, k):
    return self.comp.get(k)

class DateHelper:

  def day_format(self, day_raw):
    parseDate = RemoveDateChar()
    cleaned_day = int(day_raw.translate(parseDate))
    return cleaned_day

  def month_format(self, month_raw):
    datetime_object = datetime.datetime.strptime(month_raw, "%b")
    month_number = datetime_object.month
    return month_number 

  def year_format(self, year_raw):
    year = int(year_raw)
    return year




if __name__ == "__main__":
    main()
 

 
