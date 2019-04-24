//Package twofer solves the Exercism problem 'Two Fer'
package twofer

//ShareWith returns word play
func ShareWith(name string) string {
	if name == "" {
		name = "you"
	}
	return "One for " + name + ", one for me."

}
