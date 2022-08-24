import UIKit

class NavBar: UIView {

    @IBOutlet var contentView: UIView!
    @IBOutlet weak var title: UILabel!
    @IBOutlet weak var button: UIButton!
    
    private var _isBack = false
    @IBInspectable var isBack: Bool {
        get {
            return _isBack
        }
        set {
            
            if(newValue){
                button.setImage(UIImage.init(systemName: "chevron.left"), for: .normal)
            } else {
                button.setImage(UIImage.init(systemName: "line.horizontal.3"), for: .normal)
            }
            
            _isBack = newValue
        }
    }
    
    @IBInspectable var titleV: String {
        get {
            return title.text ?? ""
        }
        set {
            title.text = newValue
        }
    }
    
    @IBAction func showNav(_ sender: Any) {
        let parentVC = self.parentViewController
        if(_isBack){
            parentVC?.dismiss(animated: true)
            return
        }
        let vc = parentVC?.storyboard?.instantiateViewController(withIdentifier: "sidebar") as! SideMenuViewController
        vc.modalPresentationStyle = .overCurrentContext
        vc.navhandler = self.navhandler(identifierName:)
        parentVC?.present(vc, animated: false, completion: nil)
    }
    
    func navhandler(identifierName:String){
        let parentVC = self.parentViewController
        let vc = parentVC?.storyboard?.instantiateViewController(withIdentifier: identifierName) as! UIViewController
        vc.modalPresentationStyle = .overCurrentContext
        parentVC?.present(vc, animated: true)
    }
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        commonInit()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        commonInit()
    }
    
    private func commonInit(){
        Bundle.main.loadNibNamed("NavBar", owner: self, options: nil)
        addSubview(contentView)
        contentView.frame  = self.bounds
        contentView.autoresizingMask = [.flexibleTopMargin, .flexibleBottomMargin, .flexibleLeftMargin , .flexibleRightMargin]
    }
}
