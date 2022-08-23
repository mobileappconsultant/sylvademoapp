//
//  LoginViewController.swift
//  ios
//
//  Created by Joseph Peter on 22/08/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import UIKit

class LoginViewController: UIViewController {

    @IBOutlet weak var usernameTF: UITextField!
    @IBOutlet weak var passwordTF: UITextField!
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        usernameTF.layer.addBorder(edge: UIRectEdge.bottom, color: UIColor.gray, thickness: CGFloat(1))
        passwordTF.layer.addBorder(edge: UIRectEdge.bottom, color: UIColor.gray, thickness: CGFloat(1))
    }
    
}
