use strict;
use warnings;

my $s;

if(not defined $s){
	print "s is not defined!\n";
	$s = "new string";
}else{
	print "s = $s\n";
}
print "s = $s\n";