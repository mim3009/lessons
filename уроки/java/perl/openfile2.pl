use strict;
use warnings;
use v5.14;

my $filename = "input.txt";
open(my $fh, ">>", $filename) or die ("Can`t open file '$filename' . $!");
say $fh "RORORO";
close($fh);

open(my $fg, "<", $filename) or die ("Can`t open file '$filename' . $!");
foreach my $line(<$fg>){
	chomp($line);
	say $line;
}
close($fg);