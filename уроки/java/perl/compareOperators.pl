use strict;
use warnings;

my $s = "Hello";

my $e = "Hello";

my $u = "loves";

if($s eq $u){
	print "EQ\n";
}else{
	print "NEQ\n";
}

if($s lt $u){
	print "$s less than $u\n";
}else{
	print "$s greater than $u\n";
}

if($s le $e){
	print "$s less or equal $e\n";
}else{
	print "$s more than $e\n";
}

if($s > $u){
	print "$s greater than $u\n";
}else{
	print "$s less than $u\n";
}

if(12 gt 3){
	print "GT\n";
}else{
	print "LT\n";
}

if($s == ""){
	print "True\n";
}else{
	print "False\n";
}

if($s == $u){
	print "==\n";
}else{
	print "!=\n";
}
