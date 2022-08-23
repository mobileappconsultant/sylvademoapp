//
//  AppointViewMini.swift
//  ios
//
//  Created by Joseph Peter on 23/08/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import UIKit

class AppointViewMini: UIView {
    
    @IBOutlet var contentView: UIView!
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        commonInit()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        commonInit()
    }
    
    private func commonInit(){
        Bundle.main.loadNibNamed("appointmenti", owner: self, options: nil)
        addSubview(contentView)
        contentView.frame  = self.bounds
        contentView.autoresizingMask = [.flexibleTopMargin, .flexibleBottomMargin, .flexibleLeftMargin , .flexibleRightMargin]
    }
}
