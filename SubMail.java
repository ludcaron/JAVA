public class SubMail {
    public List<UserGroupsMailSubsDto> getUserGroupSubbUserCount(Integer userID) {
        List<Object[]> groupsMailsSubUserCount = groupRepository.findGroupsMailSubsUsersCount(userID);
        List<UserGroupsMailSubsDto> userGroupsMailSubsDtos = new ArrayList<>();
        for (Object[] groupMailSubUserCount : groupsMailsSubUserCount) {
            UserGroupsMailSubsDto userGroupsMailSubsDto = new UserGroupsMailSubsDto();
            userGroupsMailSubsDto.setGroupID((Integer) groupMailSubUserCount[0]);
            userGroupsMailSubsDto.setGroupName((String) groupMailSubUserCount[1]);
            userGroupsMailSubsDto.setMailSubsCount((BigInteger) groupMailSubUserCount[2]);
            userGroupsMailSubsDtos.add(userGroupsMailSubsDto);
        }
    }
}
