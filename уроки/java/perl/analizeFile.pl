#!/usr/bin/perl
use strict;
use warnings;
use v5.20;

my $s;
my $filename = "file.txt";
open(my $fh, "<", $filename) or die "Can`t open file '$filename' . $!";

my $local = 0;
my $remote = 0;

while(my $line = <$fh>){
	chomp($line);
	my $length = index($line, " ");
	my $ip = substr($line, 0, $length);
	if($ip eq "127.0.0.1"){
		$local++;
	}else{
		$remote++;
		$s = $ip;
	}
}
close($fh);
print "Local - $local, remote - $remote\n";
print "<%s>\n", trim($s);