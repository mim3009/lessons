use strict;
use warnings;

print "First value: \n";
my $f = <STDIN>;
chomp($f);

print "Second value: \n";
my $s = <STDIN>;
chomp($s);

if($s == 0){
	print "Can`t divide by zero!";
}else{
	my $r = $f / $s;
	print "The result is $r\n";
}