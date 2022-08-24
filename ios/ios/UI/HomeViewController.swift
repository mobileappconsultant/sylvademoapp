import UIKit

class HomeViewController: UIViewController {

    @IBOutlet weak var currentAppointMentV: CView!
    @IBOutlet weak var appointmentV1: AppointmentV2!
    @IBOutlet weak var appointmentV2: AppointmentV2!
    @IBOutlet weak var appointmentv3: AppointmentV2!
    @IBOutlet weak var appointmentV3: AppointmentV2!
    
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        currentAppointMentV.isUserInteractionEnabled = true
        appointmentV1.isUserInteractionEnabled = true
        appointmentV2.isUserInteractionEnabled = true
        appointmentv3.isUserInteractionEnabled = true
        appointmentV3.isUserInteractionEnabled = true
        
        var tapView = UITapGestureRecognizer(target: self, action: #selector(self.showAppointment(_:)))
        currentAppointMentV.addGestureRecognizer(tapView)
        
        tapView = UITapGestureRecognizer(target: self, action: #selector(self.showAppointment(_:)))
        appointmentV1.addGestureRecognizer(tapView)
        
        tapView = UITapGestureRecognizer(target: self, action: #selector(self.showAppointment(_:)))
        appointmentV2.addGestureRecognizer(tapView)
        
        tapView = UITapGestureRecognizer(target: self, action: #selector(self.showAppointment(_:)))
        appointmentv3.addGestureRecognizer(tapView)
        
        tapView = UITapGestureRecognizer(target: self, action: #selector(self.showAppointment(_:)))
        appointmentV3.addGestureRecognizer(tapView)
    }
    
    @IBAction func showCurrentAppointVAction(_ sender: Any) {
        showAppointment()
    }
    
    @objc func showAppointment(_ sender: UITapGestureRecognizer? = nil){
        let vc = storyboard?.instantiateViewController(withIdentifier: "appointmentVC") as! UIViewController
        vc.modalPresentationStyle = .overCurrentContext
        present(vc, animated: true, completion: nil)
    }
    
    @IBAction func showSideBarAction(_ sender: Any) {
        let vc = storyboard?.instantiateViewController(withIdentifier: "sidebar") as! SideMenuViewController
        vc.modalPresentationStyle = .overCurrentContext
        vc.navhandler = self.navhandler(identifierName:)
        present(vc, animated: false, completion: nil)
    }
    
    func navhandler(identifierName:String){
        let vc = storyboard?.instantiateViewController(withIdentifier: identifierName) as! UIViewController
        vc.modalPresentationStyle = .overCurrentContext
        present(vc, animated: true)
    }
}
