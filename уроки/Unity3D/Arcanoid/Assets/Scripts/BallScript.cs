﻿using UnityEngine;
using System.Collections;

public class BallScript : MonoBehaviour {
	
	private bool ballIsActive;
	private Vector3 ballPosition;
	private Vector2 ballInitialForce;
	public GameObject playerObject;
	public AudioClip hitSound;
	
	// Use this for initialization
	void Start () {
		ballInitialForce = new Vector2 (100.0f,300.0f);
		ballIsActive = false;
		ballPosition = transform.position;
	}
	
	// Update is called once per frame
	void Update () {
		if (Input.GetButtonDown ("Jump") == true) {
			if (!ballIsActive) {
				GetComponent<Rigidbody2D> ().isKinematic = false;
				GetComponent<Rigidbody2D> ().AddForce (ballInitialForce);
				ballIsActive = !ballIsActive;
			}
		}
		
		if (!ballIsActive && playerObject != null) {
			ballPosition.x = playerObject.transform.position.x;
			transform.position = ballPosition;
		}

		if (ballIsActive && transform.position.y < -6) {
			ballIsActive = !ballIsActive;
			ballPosition.x = playerObject.transform.position.x;
			ballPosition.y = -4.2f;
			transform.position = ballPosition;

			GetComponent<Rigidbody2D> ().isKinematic = true;

			playerObject.SendMessage ("TakeLife");
		}
	}

	void OnCollisionEnter2D(Collision2D collision){
		if (ballIsActive) {
			GetComponent<AudioSource>().PlayOneShot(hitSound);
		}
	}
}