//Package hamming calculates hamming distance
package hamming

import "errors"

//Distance calculates hamming distance
func Distance(a, b string) (int, error) {
	hammingDistance := 0

	if len(a) != len(b) {
		return hammingDistance, errors.New("strings must be the same length")
	}

	for i := 0; i < len(a); i++ {
		if a[i] != b[i] {
			hammingDistance++
		}

	}

	return hammingDistance, nil
}
