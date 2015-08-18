#!/usr/bin/perl
use strict;
use warnings;

my $filename = "in.txt";
open(my $fh, "<", $filename); 	#reading
open(my $fh, ">", $filename); 	#writting
open(my $fh, ">>", $filename); 	#appending (add to origin)
open(my $fh, "<", $filename); 	#read and write

close $fh;