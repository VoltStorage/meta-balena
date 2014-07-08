DESCRIPTION = "Resin Supervisor custom INIT file"
SECTION = "console/utils"
LICENSE = "Apache-2.0" 
PR = "r1.13"
LIC_FILES_CHKSUM = "file://${WORKDIR}/LICENSE;md5=435b266b3899aa8a959f17d41c56def8" 
SRC_URI = "file://LICENSE \
	   file://supervisor-init \
	   file://inittab \
	  "

FILES_${PN} = "${sysconfdir}/*"

do_compile() {
}

do_install() {
    
	install -d ${D}${sysconfdir}/init.d
    	install -d ${D}${sysconfdir}/rc5.d
	install -d ${D}${sysconfdir}/default
	install -d ${D}${sysconfdir}

	install -m 0755 ${WORKDIR}/supervisor-init  ${D}${sysconfdir}/init.d/
	ln -sf ../init.d/supervisor-init  ${D}${sysconfdir}/rc5.d/S99supervisor-init
	echo "BOOTLOGD_ENABLE=no" >> ${D}${sysconfdir}/default/bootlogd
	install -m 0755 ${WORKDIR}/inittab ${D}${sysconfdir}/
}

pkg_postinst_${PN} () {
#!/bin/sh -e
# Commands to carry out
}

