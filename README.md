# double-booked

A simple program taking in a set of events in the
form of a start date and end date which returns all pairs of events that
 overlap. Dates use java.util.Calendar

## Installation

Download from http://example.com/FIXME.

## Usage

This program takes sets of 10 date and time strings representing events in the following format:
  startYear startMonth startDay startHour startMinute
  endYear endMonth endDay endHour endMinute

Where startYear to startMinute denotes the start time of the event and endYear to endMinute denotes the end time of the event. This format is repeated for all events to be passed. The program prints all pairs of events that overlap with eachother.

    $ java -jar double-booked-0.1.0-standalone.jar [args]

## Options

none

## Examples

Input:
java -jar double-booked-0.1.0-standalone.jar 2016 5 11 13 30 2017 1 1 12 0 2016 4 11 17 0 2016 5 11 13 0 2016 4 10 12 0 2017 0 0 0 0
Output:
(((#inst "2016-04-10T12:00:00.000-04:00" #inst "2016-11-30T00:00:00.000-05:00") (#inst "2016-04-11T17:00:00.000-04:00" #inst "2016-05-11T13:00:00.000-04:00")) ((#inst "2016-04-10T12:00:00.000-04:00" #inst "2016-11-30T00:00:00.000-05:00") (#inst "2016-05-11T13:30:00.000-04:00" #inst "2017-01-01T12:00:00.000-05:00")))